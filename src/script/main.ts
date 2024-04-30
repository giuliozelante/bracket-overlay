import { html, render } from 'lit-html';

const headers = new Headers();

const body = JSON.stringify({
  query: `query PhaseGroupSets($phaseGroupId: ID!, $page:Int!, $perPage:Int!){
    phaseGroup(id:$phaseGroupId){
      id
      displayIdentifier
      sets(
        page: $page
        perPage: $perPage
        sortType: STANDARD
      ){
        pageInfo{
          total
        }
        nodes{
          id
          slots{
            id
            entrant{
              id
              name
            }
          }
        }
      }
    }
  }`,
  variables: {
    phaseGroupId: 2426477,
    page: 1,
    perPage: 500,
  },
});

const requestOptions = {
  method: 'POST',
  headers,
  body,
};

async function getResult() {
  const response = await fetch(
    'https://api.start.gg/gql/alpha',
    requestOptions
  );
  return await response.json();
}

// Define a template
getResult().then((result) => {
  const myTemplate = async (name: string) => html`<p>Hello ${result}</p>`;

  // Render the template to the document
  render(myTemplate('World'), document.body);
});
