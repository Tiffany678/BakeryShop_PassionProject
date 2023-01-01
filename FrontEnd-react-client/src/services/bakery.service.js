import http from "../http-common";

class BakeryDataService {
    getAll() {
        return http.get("/bakery");
    }

    async get(id) {
        return await http.get(`/cakes/${id}`);
    }

    // get(id) {
    //     return http.get(`/cakes/${id}`);
    // }

    create(data) {
        return http.post("/order", data);
    }

    update(id, data) {
        return http.put(`/cakes/${id}`, data);
    }

    submitOrder(data){
        return http.put(`/order`, data);
    }

    // delete(id) {
    //     return http.delete(`/tutorials/${id}`);
    // }

    // deleteAll() {
    //     return http.delete(`/tutorials`);
    // }

    // findByTitle(title) {
    //     return http.get(`/tutorials?title=${title}`);
    // }
}

export default new BakeryDataService();