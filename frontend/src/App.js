import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';

import { applyMiddleware } from 'redux';
import reducer from './middlewares/reducer';
import { createStore } from 'redux';
import { appMiddleware } from "./middlewares/app";
import { apiMiddleware } from "./middlewares/core";
import AuthRoute from './components/AuthRoute';

import LoginPage from './pages/LoginPage';

const createStoreWithMiddleware = applyMiddleware(
  appMiddleware,
  apiMiddleware
)(createStore);

const store = createStoreWithMiddleware(reducer);

export default function App() {
  return (
    <Provider store={store}>
      <Router>
        <div>
          <Switch>
            <AuthRoute path='/login' type='guest'>
              <LoginPage />
            </AuthRoute>
          </Switch>
        </div>
      </Router>
    </Provider>
  );
}