# Fetch Items App

This Android app retrieves and displays a list of items grouped by `listId`. The app fetches data from a public API, filters out invalid data, and presents the results in a user-friendly format. The list is sorted by `listId` and `name` while excluding items with blank or null `name` fields.

## Features
- Retrieves data from Fetch API.
- Displays items grouped by `listId`.
- Filters out any items where the `name` is blank or null.
- Sorts items first by `listId` and then by `name`.
- Implements RecyclerView to display items in an easy-to-read list.

## Technologies Used
- **Kotlin**: The app is written entirely in Kotlin.
- **Jetpack Components**: Including ViewModel, LiveData, and ViewBinding.
- **Retrofit**: For network operations to fetch data from the public API.
- **RecyclerView**: To display the fetched and sorted list of items.

## Project Setup

### Prerequisites
- **Android Studio**: (Latest stable version)
  - I have used **Android Studio Koala Feature Drop | 2024.1.2**.
- **Minimum SDK**: 24
- **Target SDK**: 34

## Expected Behavior
- The items will be grouped by their `listId`.
- Any items with a `null` or blank `name` will not be displayed.
- The remaining items will be sorted first by `listId` and then by `name`.

### Sample Output:
![image](https://github.com/user-attachments/assets/736d29a7-7c2c-4729-a455-0fa08a35a8b8)


## Project Structure

- **MainActivity.kt**: The main entry point of the app. This class initializes the RecyclerView and observes the data from the ViewModel.
- **ItemViewModel.kt**: Handles the fetching of data from the repository and provides it to the MainActivity using LiveData.
- **ItemRepository.kt**: Handles the network call to the Fetch API using Retrofit.
- **GroupedItemAdapter.kt**: The adapter for RecyclerView that groups the items by `listId`. 
- **list_item.xml**: The layout for individual items displayed in the list.
- **activity_main.xml**: The main layout that contains the RecyclerView.

## API
The app fetches data from the following public API:
- [Fetch Hiring API](https://fetch-hiring.s3.amazonaws.com/hiring.json)



