package com.toastercat.loottheroom.game;

public class Attributes
{
    // Attributes
    // modified
    private float fHealthModifier;
    private float fDevraModifier;
    private float fStaminaModifier;
    // base
    private float fHealth;
    private float fDevra;
    private float fStamina;


    public Attributes()
    {
        fHealth = 100;
        fDevra = 100;
        fStamina = 100;
    }


    /**
     * applies an increase to attributes
     */
    public void ApplyAttributes()
    {
        // TODO Auto-generated method stub
        // get the base attribute and add modified
        fHealth = fHealth + fHealthModifier;
        fDevra = fDevra + fDevraModifier;
        fStamina = fStamina + fStaminaModifier;
    }


    /**
     * unapply an increase to attributes
     */
    public void UnapplyAttributes()
    {
        // get the base attribute and minus modified
        fHealth = fHealth - fHealthModifier;
        fDevra = fDevra - fDevraModifier;
        fStamina = fStamina - fStaminaModifier;
    }


    // ----------------------------------------------------------
    /**
     * Resets the attributes to 0
     */
    public void resetAttributeModifiers()
    {
        fHealthModifier = 0;
        fDevraModifier = 0;
        fStaminaModifier = 0;
    }
}
