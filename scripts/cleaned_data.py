import sys
from pathlib import Path
import pandas as pd

# handling the input file and required extensions for the file
def load_input(input_file):
    input_path = Path(input_file)

    if not input_path.exists():
        raise FileNotFoundError(f"File not found: {input_file}")

    suffix = input_path.suffix.lower()
    if suffix == ".csv":
        return pd.read_csv(input_path)
    elif suffix in (".xlsx", ".xls"):
        return pd.read_excel(input_path)
    else:
        raise ValueError(f"Unsupported file type '{suffix}'. Use .csv or .xlsx/.xls")

# counts missing values  
def count_missing_values(df):
    missing_counts = df.isna().sum()
    missing_counts = missing_counts[missing_counts > 0]

    print("Missing values found:")
    if missing_counts.empty:
        print("No missing values")
    else:
        for col, count in missing_counts.items():
            print(f"  {col}: {count}")

    return missing_counts

# Handling missing values for categorical values
def missing_values(df):
    text_columns = df.select_dtypes(include="object").columns
    df[text_columns] = df[text_columns].fillna("Unknown")

    return df

# handling what should be the output file
def output(df, input_file):
    Path("data").mkdir(exist_ok=True)

    input_path = Path(input_file)
    suffix = input_path.suffix.lower()

    if suffix in (".xlsx", ".xls"):
        output_file = f"data/{input_path.stem}_cleaned.xlsx"
        df.to_excel(output_file, index=False)
    else:
        output_file = f"data/{input_path.stem}_cleaned.csv"
        df.to_csv(output_file, index=False)

    return output_file

def main():
    if len(sys.argv)<2:
        print("Usage: python3 cleaned_data.py <filename to clean>")
        sys.exit(1)
    
    input_file = sys.argv[1]

    try:
        df= load_input(input_file)
    except (FileNotFoundError, ValueError) as e:
        print(f"Error: {e}")
        sys.exit(1)

    count_missing_values(df)

    df = missing_values(df)

    saved_file = output(df, input_file)

    print("Cleaning complete!")
    print("Saved to:", saved_file)

if __name__ == "__main__":
    main()

