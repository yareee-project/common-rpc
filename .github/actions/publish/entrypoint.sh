#!/bin/bash
set -e

echo "🚀 Publishing module: $MODULE_NAME"

# Publish using Gradle
./gradlew $MODULE_NAME:publish -PgithubToken=$GITHUB_TOKEN

echo "✅ Module $MODULE_NAME published successfully."
