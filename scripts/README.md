## **Script Description**

This Python script automates the process of handling missing values in a CSV dataset. It reads a CSV file provided through the command line.

It then identifies numerical and categorical columns and fills the missing values based on their data types.
 
The missing values in numerical columns are replaced with **0** while missing values in categorical columns are replaced with **"Unknown"**.

After cleaning the dataset, the script creates a `data` folder if it does not already exist and saves the cleaned dataset as a new CSV file with `_cleaned` appended to the original filename. The original dataset remains unchanged, allowing users to have two seperate files the raw data and the cleaned data. 