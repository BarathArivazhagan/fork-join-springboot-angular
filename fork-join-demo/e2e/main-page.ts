import { browser, by, element } from 'protractor';

export class MainPage {
  navigateTo() {
    return browser.get('/');
  }

  getBankComponent() {
    return element(by.id('bank-container'));
  }

  getUserComponent() {
    return element(by.id('user-container'));
  }

  getUserTableBody() {
    return element(by.xpath('//*[@id="user-container"]/table/tbody'));
  }
}
