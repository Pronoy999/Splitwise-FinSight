# SplitWise - Your Free Expense Tracker & Bill Splitter
## SplitZero is an open-source, completely free Android app alternative to popular expense-splitting applications like Splitwise. It allows friends, roommates, and travel buddies to easily track shared expenses, split bills, and settle debts without any hidden fees or premium features.

🔗 Project Link
You can find the source code and contribute to SplitZero on GitHub:
https://github.com/Pronoy999/Splitwise-FinSight

✨ Features
SplitZero aims to replicate and enhance the core functionalities you love in expense management apps:

Effortless Expense Tracking: Quickly add expenses with details like who paid, who owes, and what it was for.

Smart Bill Splitting: Split bills unevenly, by percentage, by shares, or equally.

Group Management: Create groups for trips, households, or events and invite participants.

Clear Balances: See who owes whom in each group at a glance.

Simplified Debt Settlement: "Simplify Debts" feature to minimize the number of transactions needed to settle up.

Notifications: Stay informed about new expenses, payments, and activity within your groups.

Multi-currency Support: Track expenses in various currencies.

User Authentication: Secure user accounts with email/password and Google Sign-In.

Real-time Updates: See changes in expenses and balances instantly across all devices.

🚀 Technologies Used
SplitZero is built with modern, scalable technologies to ensure a robust and responsive experience:

Frontend (Android App):

React Native: Primarily focused on Android development, leveraging its cross-platform capabilities to deliver a native-like experience.

Backend & Database:

Firebase: A comprehensive mobile and web application development platform by Google.

Firebase Authentication: For secure user registration, login, and Google Sign-In.

Cloud Firestore: A NoSQL cloud database to store all expense, group, and user data in real-time.

Firebase Cloud Functions (Optional, for advanced features): To handle server-side logic like complex debt simplification or notifications.


Android Studio for Android development environment setup.

A Firebase Project (refer to Firebase documentation on how to set one up).

1. Clone the Repository

git clone https://github.com/Pronoy999/Splitwise-FinSight.git
cd Splitwise-FinSight

2. Install Dependencies

npm install # or yarn install

3. Firebase Project Configuration

Create a Firebase Project: If you haven't already, go to the Firebase Console and create a new project.

Enable Authentication Methods:

In your Firebase project, navigate to Authentication > Sign-in method.

Enable "Email/Password" and "Google" sign-in providers.

For Google Sign-In, you will need to provide your Android app's SHA-1 fingerprint. You can find this by running cd android && ./gradlew signingReport in your project's root directory, then copy the SHA-1 for your debug key and add it to your Firebase project settings under "Project settings" > "General" > "Your apps" (click on your Android app, then "Add fingerprint").

Add Android App to Firebase:

In Firebase Project settings, click "Add app" and choose the Android icon.

Enter your app's package name (e.g., com.yourcompany.splitzero).

Download the google-services.json file.

Place this google-services.json file into your Android project's app/ directory (i.e., Splitwise-FinSight/android/app/google-services.json).

Initialize Cloud Firestore:

In your Firebase project, navigate to Firestore Database.

Click "Create database" and choose "Start in production mode" (you can adjust security rules later). Select a location.

Update Firebase Security Rules (Recommended for Development):

In Firebase Console > Firestore Database > Rules tab, for initial development, you might set read/write access to authenticated users:

rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if request.auth != null;
    }
  }
}

NOTE: For production environments, implement more granular and secure rules!

4. Run the App

For Android:

npm run android # or yarn android

💡 Usage
Sign Up / Log In: Upon launching the app, create a new account using email/password or your Google account.

Create a Group: Tap the "+" icon to create a new group for your expenses (e.g., "Europe Trip 2025," "Apartment Living").

Add Members: Invite friends to your group using their email addresses (they will need to sign up for SplitZero too).

Add Expenses:

Select a group.

Tap "Add Expense."

Enter details: amount, description, who paid, and how to split it among group members.

Split options: equally, unequally, by percentage, by shares.

View Balances: The group screen will show an overview of who owes whom.

Simplify Debts: Use the "Simplify Debts" feature to streamline payments among members, reducing the total number of transactions.

Settle Up: Record payments made between members to update balances.

🤝 Contributing
We welcome contributions! If you'd like to contribute to SplitZero, please follow these steps:

Fork the repository.

Create a new branch (git checkout -b feature/your-feature-name).

Make your changes.

Commit your changes (git commit -m 'feat: Add new feature').

Push to the branch (git push origin feature/your-feature-name).

Create a new Pull Request.

Please ensure your code adheres to standard React Native practices and includes appropriate tests.

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

📧 Contact
For any questions or suggestions, feel free to open an issue in the GitHub repository or contact us at [Pronoy](https://x.com/PronoyMukherje).

