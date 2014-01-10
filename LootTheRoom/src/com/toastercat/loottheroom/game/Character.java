package com.toastercat.loottheroom.game;

public class Character
{
    private int iSpecialization;
    private int iAttribute;

    // Attributes
    private float fHealthModifier;
    private float fDevraModifier;
    private float fStaminaModifier;
    private float fHealth;
    private float fDevra;
    private float fStamina;

    // Skills
    private float fEnergyWeaponsModifier;
    private float fExplosivesModifier;
    private float fGunsModifier;
    private float fMeleeWeaponsModifier;
    private float fUnarmedModifier;
    private float fHeavyArmorModifier;
    private float fBarterModifier;
    private float fMedicineModifier;
    private float fRepairModifier;
    private float fSpeechModifier;
    private float fLightArmorModifier;

    // Skill Rates
    private double fEnergyWeaponsSkillRate;
    private double fExplosivesSkillRate;
    private double fGunsSkillRate;
    private double fMeleeWeaponsSkillRate;
    private double fUnarmedSkillRate;
    private double fHeavyArmorSkillRate;
    private double fBarterSkillRate;
    private double fMedicineSkillRate;
    private double fRepairSkillRate;
    private double fSpeechSkillRate;
    private double fLightArmorSkillRate;

    public Character()
    {

    }

    // ----------------------------------------------------------
    /**
     * Assigns the attributes and skills to the character
     */
    public void AssignAllStats()
    {
        ApplySkillValues();
        ApplyAttributes();
    }


    private void ApplyAttributes()
    {
        // TODO Auto-generated method stub
        // get the base attribute and add modified

    }

    private void ApplySkillValues()
    {
        // TODO Auto-generated method stub
        // get base skill and add modified

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

    /**
     * resets the skill values to 0
     */
    public void resetSkillValueModifiers()
    {
        fEnergyWeaponsModifier = 0;
        fExplosivesModifier = 0;
        fGunsModifier = 0;
        fMeleeWeaponsModifier = 0;
        fUnarmedModifier = 0;
        fHeavyArmorModifier = 0;
        fBarterModifier = 0;
        fMedicineModifier = 0;
        fRepairModifier = 0;
        fSpeechModifier = 0;
        fLightArmorModifier = 0;
    }

    /**
     * resets the skill rates to 100%
     */
    public void resetSkillRates()
    {
        fEnergyWeaponsSkillRate = 1.00;
        fExplosivesSkillRate = 1.00;
        fGunsSkillRate = 1.00;
        fMeleeWeaponsSkillRate = 1.00;
        fUnarmedSkillRate = 1.00;
        fHeavyArmorSkillRate = 1.00;
        fBarterSkillRate = 1.00;
        fMedicineSkillRate = 1.00;
        fRepairSkillRate = 1.00;
        fSpeechSkillRate = 1.00;
        fLightArmorSkillRate = 1.00;
    }

}
