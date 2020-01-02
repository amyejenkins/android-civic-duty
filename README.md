# Civic Duty Android

Android client for displaying local representatives 

## Architecture Notes

- MVVM
- One activity, with multiple fragments per screen.
- Each fragment has own folder with separate ViewModel
- Navigation is with android [navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
  ```
  res > navigation > navigation.xml
  ```
- Local data is stored with [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room) 
  ```
  ...civicduty
    |__database
       |-UserInfo
       |-UserInfoDao
       |-UserInfoDatabase
  ```
- (small bits of) Data passed between fragments with [Navigation safe args plugin](https://developer.android.com/guide/navigation/navigation-pass-data)
