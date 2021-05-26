import {NativeModules, NativeEventEmitter} from 'react-native'
const {helloworld} = NativeModules

const HelloWorldEmitter = new NativeEventEmitter(helloworld)

export default {
    exampleMethod(){
        return helloworld.exampleMethod()
    },

    emitter:HelloWorldEmitter,
    
    EXAMPLE_CONSTANT:helloworld.EXAMPLE_CONSTANT
}