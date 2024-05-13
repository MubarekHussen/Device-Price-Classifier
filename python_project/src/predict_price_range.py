import os
import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
from joblib import dump

os.chdir(f'{os.getcwd()}/python_project/src')


def load_data():
    """
    Load training and testing data from CSV files.
    
    Returns:
        train_data (DataFrame): Training data.
        test_data (DataFrame): Testing data.
    """
    train_data = pd.read_csv("../data/cleaned_train.csv")
    test_data = pd.read_csv("../data/test.csv")
    return train_data, test_data


def train_model(train_data):
    """
    Train a Random Forest Classifier on the training data.
    
    Args:
        train_data (DataFrame): Training data.
    
    Returns:
        clf (RandomForestClassifier): Trained classifier.
        X_val (DataFrame): Validation features.
        y_val (Series): Validation labels.
    """
    X = train_data.drop('price_range', axis=1)
    y = train_data['price_range']

    X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42)

    clf = RandomForestClassifier(n_estimators=100, random_state=42)

    clf.fit(X_train, y_train)

    dump(clf, 'random_forest.joblib')

    return clf, X_val, y_val


def evaluate_model(clf, X_val, y_val):
    """
    Evaluate the classifier on the validation data.
    
    Args:
        clf (RandomForestClassifier): Trained classifier.
        X_val (DataFrame): Validation features.
        y_val (Series): Validation labels.
    """
    val_predictions = clf.predict(X_val)

    print(f"Accuracy: {accuracy_score(y_val, val_predictions)}")

    print(confusion_matrix(y_val, val_predictions))

    print(classification_report(y_val, val_predictions))


def main():
    """
    Main function to load data, train model, and evaluate it.
    """
    train_data, test_data = load_data()
    clf, X_val, y_val = train_model(train_data)
    evaluate_model(clf, X_val, y_val)


if __name__ == "__main__":
    main()