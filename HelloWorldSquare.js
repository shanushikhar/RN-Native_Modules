import React from 'react';
import { requireNativeComponent,Text } from 'react-native'
import PropTypes from 'prop-types'

//const HelloWorldSquare = requireNativeComponent('HelloWorldSquare', HelloWorldSquareView);


export default class HelloWorldSquareView extends React.Component {
    render() {
        return (
           // <HelloWorldSquare  {...this.props} />
           <Text>hey</Text>
        )
    }
}

HelloWorldSquareView.propTypes = {
    exampleProp: PropTypes.string
}

