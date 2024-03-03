#!/bin/zsh
git pull
bundle exec jekyll build --config _config.yml,_config_secrets.yml
