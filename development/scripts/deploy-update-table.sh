#!/usr/bin/env bash
echo "Starting UPDATE TABLE deploy to RESULTS branch."

ORIGIN_URL=`git config --get remote.origin.url`
URL_WITH_CREDENTIALS=${ORIGIN_URL/\/\/github.com/\/\/$GITHUB_TOKEN@github.com}

git config --global user.email "travis@travis-ci.org"
git config --global user.name "Travis CI"

# Add table.json
git checkout
echo "Add table.json"
git add _data/table.json
echo "Commit"
git commit --allow-empty  -m "Update classification"
echo "Push"
git push --force "$URL_WITH_CREDENTIALS" > /dev/null 2>&1

echo "Deployed successfully."
exit 0
