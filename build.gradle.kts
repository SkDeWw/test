plugins {
    kotlin("multiplatform") version "1.4.10"
    id("dev.fritz2.fritz2-gradle") version "0.8"
}

repositories {
    jcenter()
    maven("https://dl.bintray.com/jwstegemann/fritz2")
}

kotlin {
    kotlin {
        jvm()
        js(LEGACY).browser()

        sourceSets {
            val commonMain by getting {
                dependencies {
                    implementation(kotlin("stdlib"))
                    implementation("dev.fritz2:styling:0.8")
                    implementation("dev.fritz2:components:0.8")
                }
            }
            val jvmMain by getting {
                dependencies {
                }
            }
            val jsMain by getting {
                dependencies {
                }
            }
        }
    }
}