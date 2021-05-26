//import liraries
import React, { useEffect,useState } from 'react';
import { View, Text, StyleSheet, NativeModules, NativeEventEmitter, Button, requireNativeComponent } from 'react-native';

import HelloWorldSquare from './HelloWorldSquare'
import HelloWorld from './HelloWorldNativeModule'


// create a component
const App = () => {

  const [nativeModule,setNativeModule] = useState(null)

  useEffect(() => {
    NativeModules.Device.getDeviceName((err, name) => console.log(err, name));
  }, [])

  const onPress = () => {
    NativeModules.Device.createCalendarEvent('testName', 'testLocation', (error, eventId) => {
      if (error) {
        console.error(`Error found! ${error}`);
      }
      console.log(`event id ${eventId} returned`);
    });
  };

  const onSubmit = async () => {
    try {
      const eventId = await NativeModules.Device.createCalendarEvent2(
        'Party',
        'My House'
      );
      console.log(`Created a new event with id ${eventId}`);
    } catch (e) {
      console.error(e);
    }
  };

  const eventEmitter = () => {
    console.log('jjj')
    const onSessionConnect = (event) => {
      console.log('onSessionConnect', event);
    };
    const eventEmitter = new NativeEventEmitter(NativeModules.Device.ToastExample);
    //eventEmitter.addListener('onSessionConnect', onSessionConnect);
    console.log(eventEmitter)
    eventEmitter.addListener('EventReminder', (event) => {
      console.log(event.eventProperty) // "someValue"
    });
  }

  const showToast = () => {
    NativeModules.Toastmodule.showToast()
  }

  useEffect(() => {
    NativeModules.Toastmodule.getDeviceId().then(text => console.log('device id..', text))
  }, [])

  useEffect(() => {
    HelloWorld.emitter.addListener('EXAMPLE_EVENT',({greeting}) =>setNativeModule(greeting))
    
    return () => HelloWorld.emitter.remove() 
  },[])

  const onPressddd = () => {
    HelloWorld.exampleMethod()
  }

  return (
    <View style={styles.container}>
      <Text onPress={onPress}>App</Text>
      <Text onPress={onSubmit}>App 2</Text>

      <Button
        title='show toast'
        onPress={showToast}
      />

      <Button
        title='event emitter'
        onPress={onPressddd}
      />
      <Text>{nativeModule}</Text>

      <HelloWorldSquare style={{ height: 100, width: 100 }} />
    </View>
  );
};

// define your styles
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

//make this component available to the app
export default App;

/**
 * tab for multi-indent
 * shift + tab for backward multi-indent
 * press ALT and then select text for selecting text and change in one go
 * ctrl + d for similar name can change in one go
 */