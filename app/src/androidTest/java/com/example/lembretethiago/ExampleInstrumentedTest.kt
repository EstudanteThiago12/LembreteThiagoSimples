package com.example.lembretethiago

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.lembretethiago", appContext.packageName)
    val activityScenario: ActivityScenario<MainActivity> =
        ActivityScenario.launch(MainActivity::class.java)

        activityScenario.moveToState(Lifecycle.State.RESUMED)

        //Tela de Login
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(withText("Seja bem Vindo")))

        onView(withId(R.id.textView2)).check(matches(isDisplayed()))
        onView(withId(R.id.textView2)).check(matches(withText("Login :")))

        onView(withId(R.id.textView3)).check(matches(isDisplayed()))
        onView(withId(R.id.textView3)).check(matches(withText("Senha :")))

        onView(withId(R.id.nome_edt)).check(matches(isDisplayed()))
        onView(withId(R.id.sobrenome_edt)).check(matches(isDisplayed()))

        //---------------------------------------------------------------

        //Tela de Cadastro
        onView(withId(R.id.textView4)).check(matches(isDisplayed()))
        onView(withId(R.id.textView4)).check(matches(withText("Cadastro")))

        onView(withId(R.id.textView5)).check(matches(isDisplayed()))
        onView(withId(R.id.textView5)).check(matches(withText("Nome :")))

        onView(withId(R.id.textView6)).check(matches(isDisplayed()))
        onView(withId(R.id.textView6)).check(matches(withText("Email :")))

        onView(withId(R.id.textView7)).check(matches(isDisplayed()))
        onView(withId(R.id.textView7)).check(matches(withText("Senha :")))

        onView(withId(R.id.tvNomeCad)).check(matches(isDisplayed()))
        onView(withId(R.id.tvEmailCad)).check(matches(isDisplayed()))
        onView(withId(R.id.tvSenhaCad)).check(matches(isDisplayed()))

        //----------------------------------------------------------


        //Tela de Lembrete
        onView(withId(R.id.Nome_txv)).check(matches(isDisplayed()))
        onView(withId(R.id.Nome_txv)).check(matches(withText("Olá, null")))

        onView(withId(R.id.TextoDigitado)).check(matches(isDisplayed()))

        onView(withId(R.id.TextoDigitado)).perform(typeText("lembrança"))

        onView(withId(R.id.buttonSalvar)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonSalvar)).perform(click())
        onView(withText("Salvar")).check(matches(isDisplayed()))

        onView(withId(R.id.TextoDigitado)).check(matches(withText("lembrança")))

        onView(withId(R.id.buttonDeletar)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonDeletar)).perform(click())
        onView(withText("Deletar")).check(matches(isDisplayed()))

        onView(withId(R.id.TextoDigitado)).perform(typeText(""))

        onView(withId(R.id.buttonVoltar)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonVoltar)).perform(click())
        onView(withText("Voltar")).check(matches(isDisplayed()))


        //Testes

        onView(withId(R.id.buttonCadastro)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonCadastro)).perform(click())
        onView(withText("Cadastro")).check(matches(isDisplayed()))

        onView(withId(R.id.tvNomeCad)).perform(typeText("Thiago"))
        onView(withId(R.id.tvNomeCad)).check(matches(isDisplayed()))
        onView(withId(R.id.tvNomeCad)).check(matches(withText("Thiago")))

        onView(withId(R.id.tvEmailCad)).perform(typeText("Thiago@gmail.com"))
        onView(withId(R.id.tvEmailCad)).check(matches(isDisplayed()))
        onView(withId(R.id.tvEmailCad)).check(matches(withText("Thiago@gmail.com")))

        onView(withId(R.id.tvSenhaCad)).perform(typeText("123456789"))
        onView(withId(R.id.tvSenhaCad)).check(matches(isDisplayed()))
        onView(withId(R.id.tvSenhaCad)).check(matches(withText("123456789")))

        onView(withId(R.id.btnCadastrarCad)).perform(click())
        onView(withText("Cadastrar")).check(matches(isDisplayed()))

        onView(withId(R.id.nome_edt)).perform(typeText("Thiago@gmail.com"))
        onView(withId(R.id.nome_edt)).check(matches(isDisplayed()))
        onView(withId(R.id.nome_edt)).check(matches(withText("Thiago@gmail.com")))

        onView(withId(R.id.sobrenome_edt)).perform(typeText("123456789"))
        onView(withId(R.id.sobrenome_edt)).check(matches(isDisplayed()))
        onView(withId(R.id.sobrenome_edt)).check(matches(withText("123456789")))

        onView(withId(R.id.button_second)).check(matches(isDisplayed()))
        onView(withId(R.id.button_second)).perform(click())
        onView(withText("Proxima")).check(matches(isDisplayed()))

        onView(withId(R.id.TextoDigitado)).perform(typeText("lembrança"))

        onView(withId(R.id.buttonSalvar)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonSalvar)).perform(click())
        onView(withText("Salvar")).check(matches(isDisplayed()))

        onView(withId(R.id.TextoDigitado)).check(matches(withText("lembrança")))

        onView(withId(R.id.buttonDeletar)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonDeletar)).perform(click())
        onView(withText("Deletar")).check(matches(isDisplayed()))

        onView(withId(R.id.TextoDigitado)).perform(typeText(""))

        onView(withId(R.id.buttonVoltar)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonVoltar)).perform(click())
        onView(withText("Voltar")).check(matches(isDisplayed()))

    }
}