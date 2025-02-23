#!/bin/bash
set -e

echo "🔹 Bumping version for module: $MODULE_NAME (Release Type: $RELEASE_TYPE)"

# Run Gradle Task to Bump Version
./gradlew bumpVersion -Pmodule=$MODULE_NAME -PreleaseType=$RELEASE_TYPE

# Get New Version from `gradle.properties`
VERSION=$(grep "${MODULE_NAME}.version=" gradle.properties | cut -d'=' -f2)

# Commit & Push Changes
git config --global user.name "github-actions[bot]"
git config --global user.email "github-actions[bot]@users.noreply.github.com"

git add gradle.properties
git commit -m "🔖 Bump $MODULE_NAME version to $VERSION"
git push origin main

echo "✅ Version bumped successfully to $VERSION."
