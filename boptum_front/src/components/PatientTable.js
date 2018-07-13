import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Row, Col, Jumbotron, Button, Table, Alert} from 'reactstrap';

class PatientTable extends Component {
  constructor() {
    super();
    this.state = {
      page: "Main"
    }
  }

  render() {
    return (
      <div className="PatientTable">
        
      </div>
    );
  }
}

export default PatientTable;
