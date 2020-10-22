node {

    stage("checkout repo") {
        git branch: 'master',
        credentialsId: '35488a89-d8e4-4d8e-add3-29cf9c62b93a'
        url: 'https://github.com/Maksim-Shkrabkou/API_UI_Java_Test_Project.git'
    }

    stage("build") {
        sh "./gradlew clean api-test:assemble"
    }

    stage("run api tests") {
        sh "./gradlew api-test:test"
    }
}