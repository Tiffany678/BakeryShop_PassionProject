import React, { Component } from "react";
import BakeryDataService from "../services/bakery.service";
import { Link } from "react-router-dom";
import getItemCount from "./Buttons/Buttons"
import Buttons from "./Buttons/Buttons";

export default class CakeList extends Component {
    constructor(props) {
        super(props);
        //this.retrieveTutorials = this.retrieveTutorials.bind(this);
        this.retrieveCakes = this.retrieveCakes.bind(this);
        this.retrieveCakesCount = this.retrieveCakesCount.bind(this);
        // let buttons  = new Buttons(props);
        //const {id} = props;
        this.state = {
            cakes: [],
            id: null
        };
    }
    componentDidMount() {
        this.retrieveCakes();
        this.retrieveCakesCount(this.props.match.params.id);
    }


    // onChangeSearchTitle(e) {
    //     const searchTitle = e.target.value;
    //
    //     this.setState({
    //         searchTitle: searchTitle
    //     });
    // }
  async getItemCount(){
        const response = await fetch(`http://localhost:8080/api/cakes/${this.buttons.id}`);
        const myJason = await response.json();
        return myJason;
  }


debugger;
    retrieveCakes() {
        // BakeryDataService.get(this.getItemCount())
        BakeryDataService.getAll()
            .then(response => {
                this.setState({
                    cakes: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    retrieveCakesCount(id) {
        // BakeryDataService.get(this.getItemCount())
        BakeryDataService.get(id)
            .then(response => {
                this.setState({
                    cakes: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }
    // refreshList() {
    //     this.retrieveTutorials();
    //     this.setState({
    //         currentTutorial: null,
    //         currentIndex: -1
    //     });
    // }
    //
    // setActiveTutorial(tutorial, index) {
    //     this.setState({
    //         currentTutorial: tutorial,
    //         currentIndex: index
    //     });
    // }
    //
    // removeAllTutorials() {
    //     TutorialDataService.deleteAll()
    //         .then(response => {
    //             console.log(response.data);
    //             this.refreshList();
    //         })
    //         .catch(e => {
    //             console.log(e);
    //         });
    // }
    //
    // searchTitle() {
    //     this.setState({
    //         currentTutorial: null,
    //         currentIndex: -1
    //     });
    //
    //     TutorialDataService.findByTitle(this.state.searchTitle)
    //         .then(response => {
    //             this.setState({
    //                 tutorials: response.data
    //             });
    //             console.log(response.data);
    //         })
    //         .catch(e => {
    //             console.log(e);
    //         });
    // }

    render() {
        const {tutorials} = this.state;

        return (

            <div className="list row">
                <div className="col-md-8">
                    <h4>Tutorials List</h4>
                </div>

                <div className="col-md-6">
                    <h4>Tutorials List</h4>
                    <h4>Tutorials List</h4><h4>Tutorials List</h4><h4>Tutorials List</h4><h4>Tutorials List</h4>
                    <ul className="list-group">
                        {tutorials}
                    </ul>
                </div>

            </div>
        );
    }
}
