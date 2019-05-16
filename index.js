/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import React from 'react';
import ReactDOM from 'react-dom';
import Datepicker from './components/Datepicker.js';
import App from './App';
import Charts from './components/Charts.js';
import './style/index.css';
import JohnData from './john_posts.json';
import JaneData from './jane_posts.json';

ReactDOM.render(
  <div>
    <form>
      <label>
        stock ticker
        <input type="text" name="name"/>
      </label>
      <input type="submit" value="Submit" />
    </form>
    <Datepicker/>
    <Datepicker/>
    <Charts dataOne={JohnData.data} dataTwo={JaneData.data}/>
  </div>,
  document.getElementById('root')
);
