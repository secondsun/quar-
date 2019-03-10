import * as React from 'react';
import Button from 'react-uwp/Button'

import {connect} from 'react-redux';

const mapStateToProps = (state, ownProps) => ({
  // ... computed data from state and optionally ownProps
})

const mapDispatchToProps = {
  // ... normally is an object full of action creators
}

export default class PortfolioShell extends React.Component {
  
    render() {
      return (
        <Button tooltip="Mini Tooltip" />
      )
    }
}


export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PortfolioShell)
