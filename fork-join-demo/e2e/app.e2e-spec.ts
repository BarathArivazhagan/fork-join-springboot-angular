import { MainPage } from './main-page';
import { browser, by, element } from 'protractor';

describe('fork-join-demo App', () => {
  let page: MainPage;

  beforeEach(() => {
    page = new MainPage();
  });

  it('should display bank component', () => {
    page.navigateTo();
    browser.wait(page.getBankComponent().isDisplayed(),3000);
    expect(page.getBankComponent().isPresent()).toBeTruthy();
  });

  it('should display user component', () => {    
    page.navigateTo();
    browser.wait(page.getUserComponent().isDisplayed(),3000);
    expect(page.getUserComponent().isPresent()).toBeTruthy();
  });

  it('expect table to be populated', () => {
    page.navigateTo();
    
    const ele = element(by.xpath('//*[@id="user-container"]/table/tbody[1]/tr/td[1]'));
    ele.getText().then( (text) => {
        console.log('text ',text);
    });
    console.log('ele '+ele.getText());
     // expect(ele.element.getText()).toBe("2");
     //console.log('hello'+tableBody.element(by.tagName("tr:nth-child(1) > td:nth-child(1)"));
  });
});
