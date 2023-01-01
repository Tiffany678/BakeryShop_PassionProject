import React, { Component } from "react";
import BakeryDataService from "../services/bakery.service";

export default class AddOrder extends Component {
    constructor(props) {
        super(props);
        this.onChangeTitle = this.onChangeTitle.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.saveTutorial = this.saveTutorial.bind(this);
        this.newTutorial = this.newTutorial.bind(this);

        this.state = {
            submitted: false
        };
    }

    onChangeTitle(e) {
        this.setState({
            title: e.target.value
        });
    }

    onChangeDescription(e) {
        this.setState({
            description: e.target.value
        });
    }

    saveTutorial() {
        var data = {
            shipping: this.state.shipping,
            subtotal: this.state.subtotal,
            total: this.state.total,
            description: this.state.description
        };

        BakeryDataService.create(data)
            .then(response => {
                this.setState({
                    shipping: response.data.shipping,
                    subtotal: response.data.subtotal,
                    description: response.data.description,
                    total: response.data.total,

                    submitted: true
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    newTutorial() {
        this.setState({
            id: null,
            title: "",
            description: "",
            published: false,

            submitted: false
        });
    }

    render() {
        return (
            <div className="submit-form">
                {this.state.submitted ? (
                    <div>
                        <h4>You submitted successfully!</h4>
                        <button className="btn btn-success" onClick={this.newTutorial}>
                            Add
                        </button>
                    </div>
                ) : (
                    <div>
                        <h4>Tutorials List</h4>
                        <h4>Tutorials List</h4>
                        <h4>Tutorials List</h4>
                        <h4>Tutorials List</h4>
                        <h4>Tutorials List</h4>
                        <div className="form-group">
                            <label htmlFor="Shipping">Shipping</label>
                            <input
                                type="number" step="0.01"
                                className="form-control"
                                id="shipping"
                                required
                                value={this.state.shipping}

                                name="shipping"
                            />
                        </div>

                        <div className="form-group">

                            <label htmlFor="description">Description</label>
                            <input
                                type="text"
                                className="form-control"
                                id="description"
                                required
                                value={this.state.description}

                                name="description"
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="Subtotal">Subtotal</label>
                            <input
                                type="number" step="0.01"
                                className="form-control"
                                id="subtotal"
                                required
                                value={this.state.subtotal}

                                name="subtotal"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="Total">Total</label>
                            <input
                                type="number" step="0.01"
                                className="form-control"
                                id="total"
                                required
                                value={this.state.total}

                                name="total"
                            />
                        </div>

                        <button onClick={this.saveTutorial} className="btn btn-success">
                            Submit
                        </button>
                    </div>
                )}
            </div>
        );
    }
}
