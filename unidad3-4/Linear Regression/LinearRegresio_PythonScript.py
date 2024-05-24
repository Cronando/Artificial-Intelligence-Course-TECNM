#   1   -   Importing libraries and viewing contents of a directory.
import numpy as np
import pandas as pd
import os

print(os.listdir("/content/datasets"))


#   2   -   Importing libraries and loading datasets
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

dataset=pd.read_csv("/content/datasets/test.csv")
dataset1=pd.read_csv("/content/datasets/train.csv")


#   3   -   Check loaded datasets
dataset

dataset1


#   4
dataset.isnull().sum()

dataset1.isnull().sum()

dataset.shape

dataset.dropna().shape

dataset.isnull().sum()

dataset=dataset.dropna()

dataset.isnull().sum()


#   5   -   
X_train = dataset.iloc[:,:-1].values
y_train = dataset.iloc[:,1].values
X_test = dataset1.iloc[:,:-1].values
y_test = dataset1.iloc[:,1].values


#   6   -   Applying regression to the assigned datasets
from sklearn.linear_model import LinearRegression
regressor=LinearRegression()
regressor.fit(X_train,y_train)


#   7   -   
y_pred = regressor.predict(X_test)


#   8   -   Visualization of the trained dataset
plt.scatter(X_train,y_train,color="red")
plt.plot(X_train,regressor.predict(X_train),color="blue")
plt.title('Linear Regression(training Set)')
plt.xlabel('X')
plt.ylabel('Y')
plt.show()


#   9   -   Visualization of the test values
plt.scatter(X_test,y_test,color="red")
plt.plot(X_train,regressor.predict(X_train),color="blue")
plt.title('Linear Regression(Test Set)')
plt.xlabel('X')
plt.ylabel('Y')
plt.show()