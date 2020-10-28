# README

## How to create a barcode/QR scanner using ZXing

<img src="Demo.gif" alt="drawing" />

<img src="OpenApp.jpg" alt="drawing" width="200"/><img src="BeforeScan.jpg" alt="drawing" width="200"/><img src="AfterScan.jpg" alt="drawing" width="200"/>

1. Create a new project 

2. Install new libraries

2.1. Gradle App level - Add a new dependency
    
     implementation 'com.journeyapps:zxing-android-embedded:3.4.0'
     
2.2. Then sync your gradle file.

3. You will also want to add permissions to your manifest file.

3.1. In this case, add the permission to use the camera. This is needed in order to actaully scan the barcodes

    <uses-permission android:name="android.permission.CAMERA" />
    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />

        
## Research / Useful Learning Resources

https://zxing.github.io/zxing/apidocs/com/google/zxing/integration/android/IntentIntegrator.html

https://www.youtube.com/watch?v=wfucGSKngq4

https://developer.android.com/guide/topics/manifest/activity-element#state

https://developer.android.com/reference/android/app/AlertDialog

https://stackoverflow.com/questions/35993253/while-using-the-intentintegrator-from-the-zxing-library-can-i-add-a-flash-butto





