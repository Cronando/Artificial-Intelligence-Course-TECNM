import cv2
import os

# Ensure OpenCV's face module is available
if not hasattr(cv2, 'face'):
    raise ImportError("cv2.face module is not available. Ensure you have 'opencv-contrib-python' installed.")

dataPath = './data'
imagePaths = os.listdir(dataPath)
print('imagePaths:', imagePaths)

# Initialize face recognizer
face_recognizer = cv2.face.EigenFaceRecognizer_create()

# Reading the model
try:
    face_recognizer.read('./eigenfacemodels/EigenFaceModel.xml')
except cv2.error as e:
    print(f"Error reading model: {e}")
    exit()

# Capture from the default camera (index 0)
cap = cv2.VideoCapture(0, cv2.CAP_DSHOW)
if not cap.isOpened():
    print("Error: Could not open video stream.")
    exit()

# Load the face detection model
faceClassif = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

while True:
    ret, frame = cap.read()
    if not ret:
        print("Error: Failed to capture image")
        break

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    auxFrame = gray.copy()

    faces = faceClassif.detectMultiScale(gray, 1.3, 5)

    for (x, y, w, h) in faces:
        face = auxFrame[y:y+h, x:x+w]
        face = cv2.resize(face, (100, 100), interpolation=cv2.INTER_CUBIC)  # Ensure the size matches training size
        result = face_recognizer.predict(face)

        cv2.putText(frame, '{}'.format(result), (x, y-5), 1, 1.3, (255, 255, 0), 1, cv2.LINE_AA)

        # EigenFaces
        if result[1] < 5700:
            cv2.putText(frame, '{}'.format(imagePaths[result[0]]), (x, y-25), 2, 1.1, (0, 255, 0), 1, cv2.LINE_AA)
            cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
        else:
            cv2.putText(frame, 'Unknown', (x, y-20), 2, 0.8, (0, 0, 255), 1, cv2.LINE_AA)
            cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 0, 255), 2)

    cv2.imshow('frame', frame)

    k = cv2.waitKey(1)
    if k == 27:
        break

    # Check if the window is still open
    if cv2.getWindowProperty('frame', cv2.WND_PROP_AUTOSIZE) < 0:
        break

cap.release()
cv2.destroyAllWindows()