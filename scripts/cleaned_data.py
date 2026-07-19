import sys
from pathlib import Path
import pandas as pd

# Get the file from the command terminal
input_file = sys.argv[1]

def missing_values(df):
    numeric_columns = df.select_dtypes(include="number").columns
    text_columns = df.select_dtypes(include="object").columns

    df[numeric_columns] = df[numeric_columns].fillna(0)
    df[text_columns] = df[text_columns].fillna("Unknown")

    return df

def output(df):
    Path("data").mkdir(exist_ok=True)

    input_path = Path(input_file)
    output_file = f"data/{input_path.stem}_cleaned.csv"
    
    df.to_csv(output_file, index=False)

    return output_file

def main():
    
    df = pd.read_csv(input_file)

    df = missing_values(df)

    saved_file = output(df)

    print("Cleaning complete!")
    print("Saved to:", saved_file)

if __name__ == "__main__":
    main()

