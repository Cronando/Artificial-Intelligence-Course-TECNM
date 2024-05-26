import cv2
import os
import numpy as np

# Ensure OpenCV's face module is available
if not hasattr(cv2, 'face'):
    raise ImportError("cv2.face module is not available. Ensure you have 'opencv-contrib-python' installed.")

dataPath = './data'
peopleList = os.listdir(dataPath)
print('List of People: ', peopleList)

labels = []
facesData = []
label = 0

# Define the desired image size (e.g., 100x100 pixels)
imageSize = (100, 100)

for nameDir in peopleList:
    personPath = os.path.join(dataPath, nameDir)
    print(personPath)
    print('Analyzing images...')

    for fileName in os.listdir(personPath):
        filePath = os.path.join(personPath, fileName)
        print('Faces: ', nameDir + '/' + fileName)
        
        # Read the image
        image = cv2.imread(filePath, 0)
        if image is None:
            print(f"Warning: Image {filePath} could not be read.")
            continue
        
        # Resize the image to the desired size
        resizedImage = cv2.resize(image, imageSize)
        
        labels.append(label)
        facesData.append(resizedImage)
        
        cv2.imshow('image', resizedImage)
        cv2.waitKey(10)
    label += 1

cv2.destroyAllWindows()

print('Labels: ', labels)
print('Number of labels 0: ', np.count_nonzero(np.array(labels) == 0))

# Create the EigenFaceRecognizer
face_recognizer = cv2.face.EigenFaceRecognizer_create()

print('Training...')
face_recognizer.train(facesData, np.array(labels))

efmPath = './eigenfacemodels'
if not os.path.exists(efmPath):
    print('Directory created: ', efmPath)
    os.makedirs(efmPath)

face_recognizer.write(os.path.join(efmPath, 'EigenFaceModel.xml'))
print('Model saved.')