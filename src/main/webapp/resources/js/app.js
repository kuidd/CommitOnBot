var app = new function() {
    this.baseUrl = "";
    this.getBaseUrl = function () {
        return this.baseUrl;
    };
    this.setBaseUrl = function (url) {
        this.baseUrl = url;
    };

}
