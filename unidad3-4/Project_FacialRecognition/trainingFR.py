import cv2
import os
import numpy as np

dataPath = './data'
peopleList = os.listdir(dataPath)
print('List of People: ', peopleList)

labels = []
facesData = []
label = 0

for nameDir in peopleList:
    personPath = dataPath + '/' + nameDir
    #   print(personPath)
    print('Analizing images...')

    for fileName in os.listdir(personPath):
        print('Faces: ', nameDir + '/' + fileName)
        labels.append(label)
        facesData.append(cv2.imread(personPath + '/' + fileName, 0))
        image = cv2.imread(personPath + '/' + fileName, 0)
        cv2.imshow('image', image)
        cv2.waitKey(10)
    label = label + 1

print('Labels: ', labels)
print('Number of labels 0: ', np.count_nonzero(np.array(labels) == 0))

face_recognizer = cv2.face.EigenFaceRecognizer_create()

print('Training...')
face_recognizer.train(facesData, np.array(labels))

efmPath = './eigenfacemodels'
if not os.path.exists(efmPath):
    print('Carpeta creada: ', efmPath)
    os.makedirs(efmPath)

face_recognizer.write(efmPath + '/' + 'EigenFaceModel.xml')
print('Saving model...')