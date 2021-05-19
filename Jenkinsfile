node {

    stage("checkout repo") {
        git branch: 'master',
        credentialsId: '35488a89-d8e4-4d8e-add3-29cf9c62b93a',
        url: 'https://github.com/Maksim-Shkrabkou/API_UI_Java_Test_Project.git'
    }

    stage("build") {
        sh "./gradlew clean api-test:assemble"
    }

    stage("run api tests") {
        sh "./gradlew api-test:test -Dlogging=${LOGGING}"
    }

    stage("run ui tests") {
        sh "./gradlew ui-test:test -Dlogging=${LOGGING}"
    }

    allure([
        includeProperties: false,
        jdk: '',
        properties: [],
        reportBuildPolicy: 'ALWAYS',
        results: [[path: 'api-test/build/allure-results'],[path: 'ui-test/build/allure-results']]
    ])
}