## **Script Description**

This Python script automates the process of handling missing values in a CSV and Excel datasets. It reads a dataset provided through the command line, verifies that the file exists and then ensres that it is in a supported format (`.csv`, `.xlsx` or `.xls`).

The script counts and displays the number of missing values in each column before cleaning the dataset. It then identifies categorical(`text`) columns and replaces the missing values with **Unknown**. In this script, the missing numerical values are not handled being that this script is mostly useful for financial datasets.

After cleaning the dataset, the script creates a `data` folder if it does not already exist and saves the cleaned dataset as a new CSV file with `_cleaned` appended to the original filename. The original dataset remains unchanged, allowing users to keep both the original data and the cleaned data. 