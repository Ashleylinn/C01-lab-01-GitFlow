[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Rwt6tbKg)
# lab-1
# CSCC01Summer25

Before you work on the lab, please go through the comprehensive overview of Git Flow.

# Git Flow Best Practices

## 1. Introduction to Git Flow

Without a clear workflow and plan, using Git can lead to a chaotic project with unorganized commits, making coordination and maintenance challenging. To address this, Vincent Driessen proposed "A Successful Git Branching Model," commonly known as Git Flow.

![Git Flow Diagram](https://nvie.com/img/git-model@2x.png)

## 2. Common Git Branches

### 2.1 Production Branch

- **Master Branch**: Contains the latest code deployed to the production environment. This branch should only receive merges from other branches; direct modifications are discouraged.

### 2.2 Develop Branch

- **Develop Branch**: Serves as the main development branch, encompassing all code intended for the next release. It primarily integrates changes from feature branches.

### 2.3 Feature Branches

- **Feature Branches**: Dedicated to developing new functionalities. Once a feature is complete, it's merged back into the develop branch for inclusion in the upcoming release.

### 2.4 Release Branches

- **Release Branches**: When preparing for a new release, a release branch is created from develop. After finalizing the release, it's merged into both master and develop branches.

### 2.5 Hotfix Branches

- **Hotfix Branches**: If a bug is discovered in production, a hotfix branch is created from master. After addressing the issue, the branch is merged back into both master and develop, ensuring the fix is included in the next release.

## 3. Git Flow Branch Operations

### 3.1 Master/Develop Branches

- **Master Branch**: Every commit should be tagged. Typically, direct commits to master are avoided.

- **Develop Branch**: Created from the master branch and serves as the integration branch for features.
<img src="image/Master Branch.png" width="100%" height="100%" alt="Master Branch">

### 3.2 Feature Branches

- **Creation**: Feature branches are created from develop.

- **Completion**: After development, merge the feature branch back into develop. It's common practice to delete the feature branch post-merge to maintain repository cleanliness.
<img src="image/Feature Branch.png" width="100%" height="100%" alt="Feature Branch">

### 3.3 Release Branches

- **Creation**: Initiated from the develop branch when preparing for a release.

- **Testing and Bug Fixes**: Conducted on the release branch.

- **Merging**: Once finalized, merge the release branch into both master and develop. Tag the master branch with the release version.

- **Deletion**: After merging, the release branch can be deleted.
<img src="image/Release Branch.png" width="100%" height="100%" alt="Release Branch">

### 3.4 Hotfix Branches

- **Creation**: Spawned from the master branch to address urgent issues in production.

- **Merging**: After resolving the issue, merge the hotfix branch into both master and develop. Tag the master branch with the hotfix version.
<img src="image/Hotfix Branch.png" width="100%" height="100%" alt="Hotfix Branch">

## 4. Git Flow Command Examples

### 4.1 Develop Branch

- **Create Develop Branch**:

  ```bash
  git branch develop
  git push -u origin develop
  ```

### 4.2 Feature Branches

- **Start a Feature**:

  ```bash
  git checkout -b feature/some-feature develop
  ```

- **Push to Remote**:

  ```bash
  git push -u origin feature/some-feature
  ```

- **Complete Feature**:

  ```bash
  git checkout develop
  git pull origin develop
  git merge --no-ff feature/some-feature
  git push origin develop
  git branch -d feature/some-feature
  git push origin --delete feature/some-feature
  ```

### 4.3 Release Branches

- **Start a Release**:

  ```bash
  git checkout -b release/0.1.0 develop
  ```

- **Complete Release**:

  ```bash
  git checkout master
  git merge --no-ff release/0.1.0
  git tag -a v0.1.0 -m "Release version 0.1.0"
  git push origin master --tags
  git checkout develop
  git merge --no-ff release/0.1.0
  git push origin develop
  git branch -d release/0.1.0
  git push origin --delete release/0.1.0
  ```

### 4.4 Hotfix Branches

- **Start a Hotfix**:

  ```bash
  git checkout -b hotfix/0.1.1 master
  ```

- **Complete Hotfix**:

  ```bash
  git checkout master
  git merge --no-ff hotfix/0.1.1
  git tag -a v0.1.1 -m "Hotfix version 0.1.1"
  git push origin master --tags
  git checkout develop
  git merge --no-ff hotfix/0.1.1
  git push origin develop
  git branch -d hotfix/0.1.1
  git push origin --delete hotfix/0.1.1
  ```

---
