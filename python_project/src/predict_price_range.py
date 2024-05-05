import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
from joblib import dump
import os

print(os.getcwd())

os.chdir(f'{os.getcwd()}/python_project/src')
print(os.getcwd())

train_data = pd.read_csv("../data/cleaned_train.csv")
test_data = pd.read_csv("../data/test.csv")

X = train_data.drop('price_range', axis=1)
y = train_data['price_range']

X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42)

clf = RandomForestClassifier(n_estimators=100, random_state=42)

clf.fit(X_train, y_train)

dump(clf, 'random_forest.joblib')

val_predictions = clf.predict(X_val)

print(f"Accuracy: {accuracy_score(y_val, val_predictions)}")

print(confusion_matrix(y_val, val_predictions))

print(classification_report(y_val, val_predictions))

test_id = test_data['id']
X_test = test_data.drop('id', axis=1)

X_test_subset = X_test[:10]
test_id_subset = test_id[:10]

predictions = clf.predict(X_test_subset)

for id, prediction in zip(test_id_subset, predictions):
    print(f"Device ID: {id}, Predicted Price Range: {prediction}")