import cv2
import os
import imutils

personName = 'Luis'
dataPath = './data'
personPath = os.path.join(dataPath, personName)
print(personPath)

# Create directory if it doesn't exist
if not os.path.exists(personPath):
    print('Carpeta creada: ', personPath)
    os.makedirs(personPath)

# Capture video
cap = cv2.VideoCapture('./videos/Luis.mp4')

# Load Haar cascade classifier for face detection
faceClassif = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
count = 0

while True:
    ret, frame = cap.read()
    if not ret:
        break
    frame = imutils.resize(frame, width=640)
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    auxFrame = frame.copy()

    faces = faceClassif.detectMultiScale(gray, 1.3, 5)

    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
        face = auxFrame[y:y+h, x:x+w]
        face = cv2.resize(face, (150, 150), interpolation=cv2.INTER_CUBIC)
        cv2.imwrite(os.path.join(personPath, f'myFace_{count}.jpg'), face)
        count += 1

    cv2.imshow('frame', frame)

    k = cv2.waitKey(1)
    if k == 27 or count >= 300:
        break

cap.release()
cv2.destroyAllWindows()
