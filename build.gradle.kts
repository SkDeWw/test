plugins {
    kotlin("multiplatform") version "1.4.10"
    id("dev.fritz2.fritz2-gradle") version "0.8"
}

repositories {
    jcenter()
}

kotlin {
    kotlin {
        js(LEGACY).browser()

        sourceSets {
            val commonMain by getting {
                dependencies {
                    implementation(kotlin("stdlib"))
                    // implementation("dev.fritz2:components:0.8")
                    // implementation("dev.fritz2:styling:0.8")
                    // implementation("dev.fritz2:core:0.8")
                    // implementation("dev.fritz2:components:0.8")
                }
            }
            val jsMain by getting {
                dependencies {

                }
            }
        }
    }
}