package deviceFactory;

public class DeviceFactory {
    public static DeviceFactoryImpl make(String type){
        DeviceFactoryImpl deviceFactoryImpl;
        switch (type.toUpperCase()){
            case "ANDROID":
                deviceFactoryImpl = new AndroidDevice();
                break;
            case "IOS":
                deviceFactoryImpl = new IosDevice();
                break;
            case "WINDOWSPHONE":
                deviceFactoryImpl = new WindowsPhoneDevice();
                break;
            case "ANDROIDCLOUD":
                deviceFactoryImpl = new AndroidCloudDevice();
                break;
            default:
                deviceFactoryImpl = null;
        }
        return deviceFactoryImpl;
    }
}
