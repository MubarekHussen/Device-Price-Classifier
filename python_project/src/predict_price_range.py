import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
from joblib import dump
import os

# Print the current working directory
print(os.getcwd())

# Change the working directory
os.chdir(f'{os.getcwd()}/python_project/src')
print(os.getcwd())

# Load the train and test datasets
train_data = pd.read_csv("../data/cleaned_train.csv")
test_data = pd.read_csv("../data/test.csv")

# Separate the features and the target variable
X = train_data.drop('price_range', axis=1)
y = train_data['price_range']

# Split the training data into a smaller training set and a validation set
X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42)

# Create a Random Forest Classifier
clf = RandomForestClassifier(n_estimators=100, random_state=42)

# Train the model on the smaller training set
clf.fit(X_train, y_train)

# Save the trained model
dump(clf, 'random_forest.joblib')

# Predict the price range for the validation set
val_predictions = clf.predict(X_val)

# Print the accuracy score
print(f"Accuracy: {accuracy_score(y_val, val_predictions)}")

# Print the confusion matrix
print(confusion_matrix(y_val, val_predictions))

# Print the classification report
print(classification_report(y_val, val_predictions))

# Separate the ID and the features
test_id = test_data['id']
X_test = test_data.drop('id', axis=1)

# Select the first 10 devices for prediction
X_test_subset = X_test[:10]
test_id_subset = test_id[:10]

# Predict the price range for the 10 devices
predictions = clf.predict(X_test_subset)

# Print the predictions
for id, prediction in zip(test_id_subset, predictions):
    print(f"Device ID: {id}, Predicted Price Range: {prediction}")