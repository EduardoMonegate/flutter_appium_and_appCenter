# Provide AppCenter/Test upload command & path to APK.
AppCenter_Test_Command='appcenter test run appium --app "fagnerfun/Dextra-Games" --devices "fagnerfun/lcsemulator" --app-path ../com.dextra.dextragames.apk --test-series "master" --locale "en_US" --build-dir target/upload'
 
# Run using the command "sh upload.sh"
Build_TestUpload_Command='mvn -DskipTests -P prepare-for-upload package'
echo $Build_TestUpload_Command
eval $Build_TestUpload_Command

AppCenter_Test_Command=${AppCenter_Test_Command}
echo $AppCenter_Test_Command
eval $AppCenter_Test_Command
