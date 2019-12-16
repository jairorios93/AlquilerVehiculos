import { browser, by, element } from 'protractor';

var MenuPage = function () {

  this.get = function () {
    browser.get('http://localhost:4200');
  };

  this.sleep = function (tiempo) {
    browser.sleep(tiempo);
  };

  this.getTitle = function () {
    return browser.getTitle();
  };
  
};
module.exports = new MenuPage();

