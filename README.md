# Introduction to Computer Science

Slide presentations used to teach basic computer science concepts, largely focused on object-oriented programming.

## Deployed site

This site is deployed [here](https://cs.nyu.edu/courses/fall24/CSCI-UA.0101-010/), and NYU credentials are required to access the site.

## Running locally

The code in this repository is used to generate the course website using [jekyll](https://jekyllrb.com/).

It is possible to run the website locally on your own machine.

- Assuming [Ruby](https://www.ruby-lang.org/en/documentation/installation/) is installed...
- Install [Jekyll](https://jekyllrb.com/) globally
- Install the dependencies listed in the `Gemfile` by running the command, `bundle`.
- run `bundle exec jekyll serve --config _config.yml,_config_dev.yml`.

The use of `--config _config.yml,_config_dev.yml` eliminates the assumption that the website is deployed at NYU.

### Attribution
This was forked from [Amos Bloomberg](https://knowledge.kitchen)'s [course materials](https://github.com/nyu-java-programming/course-materials).
