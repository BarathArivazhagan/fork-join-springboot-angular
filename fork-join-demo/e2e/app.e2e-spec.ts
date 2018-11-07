import { MainPage } from './main-page';
import { browser } from 'protractor';

describe('fork-join-demo App', () => {
  let page: MainPage;

  beforeEach(() => {
    page = new MainPage();
  });

  it('should display bank component', () => {
    page.navigateTo();
    browser.wait(page.getBankComponent().isDisplayed())
    expect(page.getBankComponent().isPresent()).toBeTruthy();
  });

  it('should display user component', () => {
    page.navigateTo();
    browser.wait(page.getUserComponent().isDisplayed())
    expect(page.getUserComponent().isPresent()).toBeTruthy();
  });
});
