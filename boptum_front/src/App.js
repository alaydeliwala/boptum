import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Profile from './components/profile';
import Main from './components/Main';
import { Container, Row, Col, Navbar, NavbarBrand, NavItem, Nav, Input, ListGroup, ListGroupItem } from 'reactstrap';

class App extends Component {
  constructor() {
    super();
    this.state = {
      page: "Main",
      searchTerm: "",
      patientList:[]
    }
    const patients = [
      "Ben Dover", "Hugh Jass", "Mike Hunt", "Deez Nuts", "Lebron James"
    ]
    this.state.patientList = patients.map((item, index) =>
    //append each patient to a list to be inserted below nav bar
      <ListGroupItem className="search-result" key={index}><a href="#">{item}</a></ListGroupItem>
    );
  }

  handleChange = (e) => {
    //bind user input in search bar to model
    this.setState({searchTerm: e.target.value});
  }
  renderPage() {
    if(this.state.page === "Home") { return; }
    else if(this.state.page === "Profile") { return <Profile/>; }
    else if(this.state.page === "Main") { return <Main />; }
  }

  search = (e) => {
    this.setState({searchTerm: e.target.value});//bind user input in search bar to model

    var filter = this.state.searchTerm.toUpperCase();
    var ul = document.getElementById("searchUl");
    var li = ul.getElementsByTagName('li');
    //loop over patient names, hiding those that don't match the search term
    for (var i = 0; i < li.length; i++) {
      let a = li[i].getElementsByTagName("a")[0];

      if (filter==="" || a.innerHTML.toUpperCase().indexOf(filter)>-1) {//match
        li[i].style.display = "";
      }
      else { li[i].style.display="none" ;}
    }
  }

  showList() {
    //display the list of all patients when search bar clicked
    var list = document.getElementById("searchUl");
    list.style.display = "block";
    var li = list.getElementsByTagName("li");
    for (var i = 0; i < li.length; i++) {
      let a = li[i].getElementsByTagName("a")[0];
      console.log(a.innerHTML)
      a.style.display = "";
    }
    //TODO: hide whatever part the list will cover
  }

  hideList() {
    var list = document.getElementById("searchUl");
    list.style.display = "none";
    //TODO: show whatever was behind the list
  }

  render() {
    return (
      <div className="App">
        <Navbar color="light" light expand="md">
          <NavbarBrand href="#" onClick={() => this.setState({page:"Main"})}> boptum </NavbarBrand>
          <Nav className="ml-auto" navbar>
            <NavItem>
              <a href="#" onClick={() => this.setState({page:"Profile"})}>Profile</a>
            </NavItem>
            <NavItem>
              <Input type="text" placeholder="Patient Search" value={this.state.searchTerm} onClick={this.showList} onChange={this.search} onBlur={this.hideList} />
            </NavItem>
          </Nav>
        </Navbar>
        <Container fluid>
          <Row>
            <Col xs="2" sm={{size:2, offset: 10}}>
            <ListGroup id="searchUl" style={{display:"none"}} onClick={this.hideList} >
              {this.state.patientList}
           </ListGroup>
           </Col>
          </Row>
        
          {this.renderPage()}
        </Container>
      </div>
    );
  }
}

export default App;
