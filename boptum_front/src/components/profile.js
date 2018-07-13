import React, { Component } from 'react';
import { Jumbotron, Media, Button, Container, Row, Col, ListGroupItemHeading } from 'reactstrap'

class Profile extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: "John Doe",
            contact: "(919) 555-4444",
            disorders: ["Diabetes", "Rabies", "Hypertension"],
            description: "This is some text that has something to do with the patients. Maybe an address.",
            prescriptions: ["Drug 1", "Drug 2", "Drug 3"],
            prescList: null,
            disordersList: null
        } 
        this.prescList = this.state.prescriptions.map((item, index) =>
            <li key={index}>{item}</li>
        );
        this.disordersList = this.state.disorders.map((item, index) =>
            <li key={index}>{item}</li>
        );
    }
    

    render() {
        return (
            <div className="Profile">
                <Jumbotron>
                    <Container fluid>
                        <img src="/src/assets/harold.jpg" alt="" />
                        <h1 className="display-6">{this.state.name}</h1>
                        <p className="lead">{this.state.contact}</p>
                        <hr className="my-2" />
                        <p>{this.state.description}</p>
                            {/* <Button color="primary">Learn More</Button> */}
                            <Row>
                                <Col xs="6">
                                    <ul style={{listStyle:"none"}}>
                                    <ListGroupItemHeading>Disorders</ListGroupItemHeading>
                                        {this.disordersList}
                                    </ul>
                                </Col>
                                <Col xs="6">
                                    
                                    <ListGroupItemHeading>Prescriptions</ListGroupItemHeading>
                                        <ul style={{listStyle:"none"}}>{this.prescList}</ul>
                                    
                                </Col>
                            </Row>
                    </Container>
                </Jumbotron>
            </div>
        );
    }
}

export default Profile;