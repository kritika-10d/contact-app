# Contributing to Contact App
First off, thanks for taking the time to contribute. 
The following is a set of guidelines for contributing to Contact App and its packages, which are hosted in the (https://github.com/praveenrawal/contact-app) on GitHub. 
These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

## CODE OF CONDUCT
This project and everyone participating in it is governed by the [CODE OF CONDUCT](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. 
Please report unacceptable behavior to [komalshekhawat414@gmail.com](mailto:komalshekhawat414@gmail.com).

## LET'S GET STARTED

To get an overview of the project, read the [README](README.md). Here are some resources to help you get started with open source contributions:

- [Finding ways to contribute to open source on GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github)
- [Set up Git](https://docs.github.com/en/get-started/quickstart/set-up-git)
- [GitHub flow](https://docs.github.com/en/get-started/quickstart/github-flow)
- [Collaborating with pull requests](https://docs.github.com/en/github/collaborating-with-pull-requests)


## How Can I Contribute?

### Issues

#### Create a new issue

If you spot a problem with the docs, [search if an issue already exists](https://docs.github.com/en/github/searching-for-information-on-github/searching-on-github/searching-issues-and-pull-requests#search-by-the-title-body-or-comments). If a related issue doesn't exist, you can open a new issue using a relevant [issue form](https://github.com/github/docs/issues/new/choose). 

#### Solve an issue

Scan through our [existing issues](https://github.com/github/docs/issues) to find one that interests you. You can narrow down the search using `labels` as filters. See [Labels](/contributing/how-to-use-labels.md) for more information.

#### Make changes in the UI

Click **Make a contribution** at the bottom of any docs page to make small changes such as a typo, sentence fix, or a broken link. 
This takes you to the `.md` file where you can make your changes and [create a pull request](#pull-request) for a review. 


#### Make changes in the CODE

The best way to contribute is to "clone" your fork of contact-app to your development area. That sounds like some jargon, but "forking" on GitHub means 
"making a copy of that repo to your account" and "cloning" means "copying that code to your environment so you can work on it".

1. [Set up Git](https://help.github.com/en/articles/set-up-git) (Windows, Mac & Linux)
2. Go to the [contact-app repo](praveenrawal/contact-app)
3. [Fork it](https://help.github.com/en/articles/fork-a-repo)
4. [Clone](https://github.com/kritika-10d/contact-app.git) your forked contact-app repo: git@github.com:<your-name>/contact-app.git.
5. Checkout the "develop" branch. At this point you are ready to start making changes.
6. Fix existing bugs on the Issue tracker after taking a look to see nobody else is working on them.
7. [Commit](https://help.github.com/en/articles/adding-a-file-to-a-repository-using-the-command-line) the files
8. [Push](https://help.github.com/en/articles/pushing-to-a-remote) your develop branch to your fork
9. [Send a pull request](https://help.github.com/en/articles/creating-a-pull-request)

We will now be alerted about the change and at least one of the team will respond. If your change fails to meet the guidelines it will be bounced, 
  or feedback will be provided to help you improve it.
Once we handle your pull request, we will merge it into develop and your patch will be part of the next release.
  
### Keeping your fork up-to-date

Unlike systems like Subversion, Git can have multiple remotes. A remote is the name for a URL of a Git repository. By default your fork will have a remote named "origin" which points to your fork, but you can add another remote named "contact app" which points to `git://github.com/bcit-ci/contact-app.git`. This is a read-only remote but you can pull from this develop branch to update your own.

If you are using command-line you can do the following:

1. `git remote add contact-app git://github.com/bcit-ci/contact-app.git`
2. `git pull contact-app develop`
3. `git push origin develop`

Now your fork is up to date. This should be done regularly, or before you send a pull request at least.



