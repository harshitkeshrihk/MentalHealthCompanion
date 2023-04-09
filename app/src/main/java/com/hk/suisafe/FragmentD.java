package com.hk.suisafe;

import static android.content.Context.ALARM_SERVICE;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.tensorflow.lite.Interpreter;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import kotlinx.coroutines.GlobalScope;


public class FragmentD extends Fragment {


    //fitband
    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_ACCESS_COARSE_LOCATION = 2;
    BluetoothAdapter bluetoothAdapter;


    public static final String ARG_PAGE = "ARG_PAGE";
    float prediction;
    Interpreter tflite;


    private static final String CHANNEL_ID = "alarm_channel";
    private int notificationId = 1;


    public static FragmentD newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentD fragment = new FragmentD();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View w = inflater.inflate(R.layout.fragment_d, container, false);
        return w;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button score = view.findViewById(R.id.button);
        TextView t = view.findViewById(R.id.tt2);
        EditText ee1 = view.findViewById(R.id.e1);
        EditText ee2 = view.findViewById(R.id.e2);
        EditText ee3 = view.findViewById(R.id.e3);
        EditText ee4 = view.findViewById(R.id.e4);

//        try {
//            tflite = new Interpreter(loadModelFile());
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        double[][] X = {{3.0, 6.0, 9.0, 7.0}, {2.0, 5.0, 8.0, 5.0}, {3.0, 6.0, 9.0, 5.0}, {4, 7, 7, 4}, {5, 8, 6, 5},
                {6, 4, 6, 6}, {7, 3, 6, 3}, {4, 5, 6, 4}, {3, 8, 8, 7}, {2, 7, 9, 7}, {1, 6, 9, 8}, {8, 3, 3, 1}, {3, 6, 7, 6},
                {9, 1, 3, 0}, {8, 2, 2, 1}, {7, 3, 5, 2}, {5, 4, 6, 5}, {6, 6, 5, 3}, {7, 3, 3, 2}, {8, 2, 2, 1}, {9, 1, 1, 0},
                {2, 8, 8, 6}, {3, 6, 7, 7}, {4, 6, 6, 8}, {5, 5, 5, 7}, {3, 7, 8, 8}, {2, 7, 7, 8}, {4, 6, 6, 6}, {5, 5, 5, 5},
                {4, 6, 6, 6}, {7, 3, 3, 3}, {8, 2, 2, 2}, {9, 1, 1, 1}, {8, 2, 3, 0}, {6, 4, 4, 4}, {7, 3, 3, 3}, {8, 2, 3, 2},
                {7, 1, 4, 1}, {6, 2, 4, 3}
        };

        // Define the dependent variable as a 1D array
        double[] y = {12, 10, 12, 34, 38, 40, 61, 55, 41, 11, 8, 50, 15, 78, 71, 68, 55, 67, 74, 88, 85, 32, 22, 34, 54, 36,
                21, 43, 45, 43, 64, 68, 89, 88, 76, 75, 79, 75, 59};   // Example happiness scores for the 3 data points

        // Fit a multiple linear regression model to the data
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        regression.newSampleData(y, X);
        double[] coefficients = regression.estimateRegressionParameters();


        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ee1.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Mandatory to be filled!!!", Toast.LENGTH_SHORT).show();
                } else if (ee2.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Mandatory to be filled!!!", Toast.LENGTH_SHORT).show();
                } else if (ee3.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Mandatory to be filled!!!", Toast.LENGTH_SHORT).show();
                } else if (ee4.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Mandatory to be filled!!!", Toast.LENGTH_SHORT).show();
                } else {

                    float a = Float.parseFloat(ee1.getText().toString());
                    float b = Float.parseFloat(ee2.getText().toString());
                    float c = Float.parseFloat(ee3.getText().toString());
                    float d = Float.parseFloat(ee4.getText().toString());


                    double[] newPoint = {a, b, c, d};
                    double predictedHappinessScore = coefficients[0] + coefficients[1] * newPoint[0] + coefficients[2] * newPoint[1] + coefficients[3] * newPoint[2] + coefficients[4] * newPoint[3];
                    System.out.println("Predicted happiness score: " + predictedHappinessScore);
                    t.setText(Double.toString(predictedHappinessScore));

                    if (predictedHappinessScore < 40.0) {
//                        showAlarm();

                        Intent intent = new Intent(requireContext(), AlarmActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    class AlarmTask extends TimerTask {
        public void run() {
            // Display a notification
            displayNotification("Alarm! Time to wake up!");
        }
    }

    private void displayNotification(String message) {
        NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Alarm Channel", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(requireContext())
                .setContentTitle("Alarm")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        notificationManager.notify(notificationId++, notification);
    }


    private void showAlarm() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View view2 = inflater.inflate(R.layout.dailog_layout, null);
        final EditText editText = view2.findViewById(R.id.edit_text);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Set Alarm Time")
                .setView(view2)
                .setPositiveButton("Set", (dialog, which) -> {
                    // Parse the input time
                    String inputTime = editText.getText().toString();
                    String[] parts = inputTime.split(":");
                    int hours = Integer.parseInt(parts[0]);
                    int minutes = Integer.parseInt(parts[1]);

                    Calendar alarmTime = Calendar.getInstance();
                    alarmTime.set(Calendar.HOUR_OF_DAY, hours); // set the hour in 24-hour format
                    alarmTime.set(Calendar.MINUTE, minutes);
                    alarmTime.set(Calendar.SECOND, 0);

                    Timer timer = new Timer();
                    timer.schedule(new AlarmTask(), alarmTime.getTime(), 24 * 60 * 60 * 1000); // repeat daily

                    // Display a notification to confirm that the alarm has been set
                    Log.d("checkalarm", timer.toString());
                    displayNotification("Alarm set for " + alarmTime.getTime());
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    //function to connect fitbands..yet to be tested.
    //bluetooth connection for fitband
    private void BlueToothConnection() {
        if (!requireContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            // Device does not support Bluetooth Low Energy.
            Toast.makeText(requireContext(), "BlueTooth service not available on device", Toast.LENGTH_SHORT).show();
        } else {

            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (!checkBluetoothPermission()) {
                return;
            }else{
                bluetoothAdapter.startLeScan(leScanCallback);
            }
        }
    }

    public boolean checkBluetoothPermission() {
        boolean isPermissionGranted = false;
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED) {
            // Bluetooth permission is granted
            isPermissionGranted = true;
        } else {
            // Bluetooth permission is not granted, request for permission
            ActivityCompat.requestPermissions(requireActivity(), new String[] { android.Manifest.permission.BLUETOOTH_SCAN }, REQUEST_ENABLE_BT);
        }
        return isPermissionGranted;
    }

    // Define a callback for when a device is found
    private BluetoothAdapter.LeScanCallback leScanCallback =
            new BluetoothAdapter.LeScanCallback() {
                @SuppressLint("MissingPermission")
                @Override
                public void onLeScan(final BluetoothDevice device, int rssi,
                                     byte[] scanRecord) {
                    if (device.getName().equals("fitband_name")) {
                        // Connect to the device
                        BluetoothGatt bluetoothGatt = device.connectGatt(requireContext(), false, gattCallback);
                        bluetoothGatt.connect();
                    }
                }
            };


//     Define a callback for when the connection is established
    private BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
    @SuppressLint("MissingPermission")
    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status,
                                        int newState) {
        if (newState == BluetoothProfile.STATE_CONNECTED) {
            // Discover services on the device
            gatt.discoverServices();
        }
    }
};

    @SuppressLint("MissingPermission")
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        // Get the Heart Rate service from the device
        BluetoothGattService heartRateService = gatt.getService(UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb"));

        // Get the Heart Rate characteristic from the service
        BluetoothGattCharacteristic heartRateCharacteristic = heartRateService.getCharacteristic(UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb"));

        // Enable notifications on the characteristic
        gatt.setCharacteristicNotification(heartRateCharacteristic, true);
        BluetoothGattDescriptor descriptor = heartRateCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        gatt.writeDescriptor(descriptor);
    }


    public void onCharacteristicChanged(BluetoothGatt gatt,
                                        BluetoothGattCharacteristic characteristic) {
        if (characteristic.getUuid().equals(UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb"))) {
            // Heart rate value has changed
            int heartRate = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 1);
            // Do something with the heart rate value
        }
    }


    @SuppressLint("MissingPermission")
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Bluetooth permission is granted
                    // Perform Bluetooth related operations
                    bluetoothAdapter.startLeScan(leScanCallback);
                } else {
                    // Bluetooth permission is not granted
                    // Show a message to the user or disable Bluetooth related features
                }
                break;
            case REQUEST_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Location permission is granted
                    // Perform Bluetooth related operations
                } else {
                    // Location permission is not granted
                    // Show a message to the user or disable Bluetooth related features
                }
                return;
        }
    }




}