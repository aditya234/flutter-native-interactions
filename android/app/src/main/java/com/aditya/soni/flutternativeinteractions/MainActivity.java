package com.aditya.soni.flutternativeinteractions;

import android.os.Bundle;

import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "soni.aditya.com/info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);

        new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                        final Map<String, Object> arguments = methodCall.arguments();
                        if (methodCall.method.equals("getMessage")) {
                            String from = (String) arguments.get("from");
                            String message = "Android Says Hi " + from;
                            result.success(message);
                        }
                    }
                }
        );
    }
}
