import React, { Component } from 'react';
import { Container, Row, Col, Jumbotron, Button, Table, Alert} from 'reactstrap';
import './Main.css';
import profile from '../assets/profile-clipart-generic-user-12.png'


class Main extends React.Component {
    constructor(props) {
        super(props)
        this.name = "Main Page";
    }

    render() {
        return (
            <div className="Main" style={{width: '100%'}}>
              <Container fluid>
                <Row>
                <Col>
                 <Alert className="aRight big-font" color="primary">Welcome Dr. Robins</Alert>
                </Col>
                </Row>
                <Row>
                  <Col className="side padding-1" xs="3">
                    <img src={profile} alt="profile" style={{width:'50%'}}/>
                  </Col>
                  <Col className = "margin-1">
                  <Row>
                  <Alert className="aLeft" color="danger">Critical Patients</Alert>
                  <Table striped>
                      <thead>
                        <tr>
                          <th>Patient ID</th>
                          <th>Last Name</th>
                          <th>First Name</th>
                          <th>DOB</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <th scope="row">1</th>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr>
                          <th scope="row">2</th>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                          <th scope="row">3</th>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </Table>
                    </Row>
                    <Row>
                    <Alert className="aLeft" color="warning">Upcoming Patients</Alert>
                    <Table striped>
                        <thead>
                          <tr>
                            <th>Patient ID</th>
                            <th>Last Name</th>
                            <th>First Name</th>
                            <th>DOB</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                          </tr>
                          <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                          </tr>
                          <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                          </tr>
                        </tbody>
                      </Table>
                      </Row>
                      <Row>
                      <Alert className="aLeft" color="primary">Recent Patients</Alert>
                      <Table striped>
                          <thead>
                            <tr>
                              <th>Patient ID</th>
                              <th>Last Name</th>
                              <th>First Name</th>
                              <th>DOB</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <th scope="row">1</th>
                              <td>Mark</td>
                              <td>Otto</td>
                              <td>@mdo</td>
                            </tr>
                            <tr>
                              <th scope="row">2</th>
                              <td>Jacob</td>
                              <td>Thornton</td>
                              <td>@fat</td>
                            </tr>
                            <tr>
                              <th scope="row">3</th>
                              <td>Larry</td>
                              <td>the Bird</td>
                              <td>@twitter</td>
                            </tr>
                          </tbody>
                        </Table>
                        </Row>
                  </Col>
                </Row>
              </Container>
            </div>
        );
    }
}

export default Main;
