import React, {useState, useEffect} from "react";
import {Container, Form, Button, Row, Col} from "react-bootstrap";
import {useDispatch} from "react-redux";
import {$httpLogin, $signUpManager } from "../modules/api/user";
import { useHistory } from 'react-router-dom';
import Modal from "react-bootstrap/Modal";

export default () => {

    let [id, setId] = useState('')
    let [pwd, setPwd] = useState('')
    let [modalShow, setModalShow] = React.useState(false);

    const history = useHistory();
    let dispatch = useDispatch();

    let loginUser = () => {
        $httpLogin(dispatch, {"email": id.value, "password": pwd.value}, history)
    };

    let _keyDown = (event) => {
        if(event.key === 'Enter'){
           loginUser()
        }
    }

    return (
        <div id="loginWrap">
            <div id="loginBox">
                <Container>

                    <Row className="test">
                        <p>
                            Logo Box
                        </p>
                    </Row>

                    <Row className="test">
                        <Container>
                            <Form>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Email address</Form.Label>
                                    <Form.Control type="email" placeholder="Enter email"
                                                  ref={input => setId(input)}
                                                  onKeyPress={_keyDown}
                                    />
                                </Form.Group>
                                {/*input end*/}
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control type="password" placeholder="Password"
                                                  ref={input => setPwd(input)}
                                                  onKeyPress={_keyDown}
                                    />
                                </Form.Group>
                                {/*password input end*/}

                                <Button variant="dark" size="lg" block
                                        onClick={loginUser}>
                                    Login
                                </Button>

                                <Button variant="primary" size="lg" block  onClick={() => setModalShow(true)}>
                                    Sign Up
                                </Button>

                            </Form>

                            <MyVerticallyCenteredModal
                                dispatch={dispatch}
                                show={modalShow}
                                onHide={() => setModalShow(false)}
                            />

                        </Container>
                    </Row>

                </Container>
                {/* Container end*/}
            </div>
            {/*#loginBox end*/}
        </div>
        // #loginWrap end
    )
}

function MyVerticallyCenteredModal(props) {

    let dispatch = props.dispatch

    let [email, setEmail] = useState("");

    let [pwd, setPwd] = useState("");

    let [address, setAddress] = useState("");

    let [birthDate, setBirthDate] = useState("");

    let _onClickOk = () => {

        $signUpManager(dispatch, {
            "email": email.value,
            "password": pwd.value,
            "address": address.value,
            "birthDate": birthDate.value,
            "img": "default.jpg",
            "isUse": true
        })
            .then((res) => props.onHide)
            .catch(err => console.log(err))

    }

    return (
        <Modal
            {...props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Sign Up
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
               <Form >
                   <Form.Group>
                       <Form.Label>Email address</Form.Label>
                       <Form.Control type="email" placeholder="Enter email"A
                                     autoComplete="nope"
                                     ref={input => setEmail(input)}
                       />
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Password</Form.Label>
                       <Form.Control type="password" placeholder="Password"
                                     ref={input => setPwd(input)}
                       />
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Address</Form.Label>
                       <Form.Control
                                     type="text"
                                     placeholder="Address"
                                     ref={input => setAddress(input)}
                       />
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>BirthDate</Form.Label>
                       <Form.Control type="date"
                                     ref={input => setBirthDate(input)}
                       />
                   </Form.Group>
               </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={()=> _onClickOk}>Ok</Button>
                <Button onClick={props.onHide}>Close</Button>
            </Modal.Footer>
        </Modal>
    );
}

