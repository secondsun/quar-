import React from 'react';
import ReactDOM from 'react-dom';


import { Provider } from 'react-redux'
import store from './store'


import { Theme as UWPThemeProvider, getTheme } from 'react-uwp/Theme'
import AppShell from './src/AppShell'


export class App extends React.Component {
  render() {
    return (
      <Provider store={store}>
        <UWPThemeProvider
          theme={getTheme({
            themeName: "dark", // set custom theme
            accent: "#0078D7", // set accent color
            useFluentDesign: true, // sure you want use new fluent design.
            desktopBackgroundImage: "http://127.0.0.1:9080/background.jpg" // set global desktop background image
          })}
        >
          <AppShell />
        </UWPThemeProvider>
      </Provider>
    )
  }
}

ReactDOM.render(
  <App />,
  document.getElementById("app")
);


